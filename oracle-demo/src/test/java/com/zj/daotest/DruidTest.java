package com.zj.daotest;
 
import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;
 
 
/**  
 * @Description:    Druid加解密(用一句话描述该文件做什么)   
 * @author: qixiongfei     
 * @date:   2022年4月11日 下午2:33:25   
 * @version V1.0 
 */  
public class DruidTest extends DruidPasswordCallback {
 
    public static void main(String[] args) throws Exception {
	String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJdHcsWAJwUkcWLLp14J8pumGsgZHLQSlNCRgQyJoY6NWO2WICcvZJCPUQp7klK35P8m+zzRXmPUS4JutY54nicCAwEAAQ==";
	String password = "ipukVSFNoxQHoxVHWVd0q20lMsRNIgKuW2TSprCqejRYGKhpJSE3wBRTjHH2MqJ+WYvoOp7T+vovKx1F6enBKw==";
	String pwd = ConfigTools.decrypt(publickey, password);
 
	System.out.println(pwd);
    }
}