package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.util.List;

public class ReadJsonFile implements ReadData {

    public Object[][] getData() {

        try {

            String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("LoginData.json"));

            Gson gson = new Gson();

            List<ReadLoginData> logins = gson.fromJson(json, new TypeToken<List<ReadLoginData>>(){}.getType());

            Object [][] result = new Object[logins.size()][];
            for(int i = 0; i < result.length ; i ++ ) {
                result[i] = new Object[]{ logins.get(i) };

            }
            return result;

        }
        catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}

