package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class GetFollowers {

	public static void main(String[] args) {
		String access_token = args[0];
		Friendships fm = new Friendships();
		fm.client.setToken(access_token);
		String screen_name = args[1];
		try {
			// UserWapper users = fm.getFollowersByName(screen_name);

			int count = 0;

			for (UserWapper users = fm.getFollowersByName(screen_name);;) {
				
				

			}

		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
