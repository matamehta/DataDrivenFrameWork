package helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadJsonData  {

    public List<Login> getData() {

        try {

            String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("Login.json"));

            Gson gson = new Gson();

            List<Login> logins = gson.fromJson(json, new TypeToken<List<Login>>(){}.getType());
            return logins;

        }
        catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}

