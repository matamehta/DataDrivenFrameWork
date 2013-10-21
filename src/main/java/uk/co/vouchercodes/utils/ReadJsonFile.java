package uk.co.vouchercodes.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import uk.co.vouchercodes.framework.ReadLogInData;
import uk.co.vouchercodes.framework.ReadData;

import java.util.List;

public class ReadJsonFile implements ReadData {

    public Object[][] getData() {

        try {
            // Converting the data in JsonFile into string and converting the string to List of objects.

            String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("SignInData.json"));
            Gson gson = new Gson();
            List<ReadLogInData> logins = gson.fromJson(json, new TypeToken<List<ReadLogInData>>(){}.getType());

            // Converting the List of objects into Array

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

