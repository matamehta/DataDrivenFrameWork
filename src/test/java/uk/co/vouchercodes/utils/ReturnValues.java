package uk.co.vouchercodes.utils;

import uk.co.vouchercodes.framework.PropertyUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: sakodali
 * Date: 10/11/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReturnValues {



    @Test
    public void getBaseUrl(){

        System.out.println(PropertyUtils.getProtocol());
    }

}
