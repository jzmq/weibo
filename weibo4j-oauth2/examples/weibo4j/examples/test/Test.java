package weibo4j.examples.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

public class Test {
	
	
	public static void main(String[] args) throws WeiboException, IOException{
		
		
		//step 1 认证，取得tokens
		Oauth oauth = new Oauth();
		BareBonesBrowserLaunch.openURL(oauth.authorize("code",args[0],args[1]));
		System.out.println(oauth.authorize("code",args[0],args[1]));
		
		//这里获取到服务器端返回的code
		//http://weibo.com/zhumingqing?wvr=5&state=zhu.mingqing%40qq.com&code=19e4d931e929b8ba5c1e516dc40b3522
		
//		String codex = 
		
		
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		Log.logInfo("code: " + code);
		try{
			System.out.println(oauth.getAccessTokenByCode(code));
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}
		
		
		
	}

}
