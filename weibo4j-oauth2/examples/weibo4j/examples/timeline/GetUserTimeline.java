package weibo4j.examples.timeline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import weibo4j.Timeline;
import weibo4j.model.Paging;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetUserTimeline {

	public static void main(String[] args) throws IOException {

		String access_token = args[0];
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		
		String screen_name = "";//输入用户的显示名称
		
		String newFile = "E:/"+screen_name;
		
		BufferedWriter bwriter = null;
		
		

		int count = 0;

		try {
			
			bwriter = new BufferedWriter(new FileWriter(new File(newFile)));
			
			StatusWapper status = tm.getUserTimelineByName(screen_name);
			
			int total = (int) status.getTotalNumber();
			int perPage = 50;
			int totalPage = total/perPage;
			System.out.println(totalPage);
			
			for(int i =1;i<=totalPage+2;i++){
				
				Paging page = new Paging();
				page.setCount(perPage);
				page.setPage(i);
				
				StatusWapper status_all = tm.getUserTimelineByName(screen_name, page, 0, 0);
				
				for (Status s : status_all.getStatuses()) {
					
//					System.out.println(s.getText());//需要寫入文件
					
					bwriter.write(s.getText());
					bwriter.write("\n");
					
					if (s.getRetweetedStatus() != null) {
						Status tmp = s.getRetweetedStatus();

//						System.out.println(tmp.getText());//需要寫入文件
						
						bwriter.write(tmp.getText());
						bwriter.write("\n");

						count++;
					}else{
						count++;
					}
					
					bwriter.write("\n");
					// Log.logInfo(s.toString());
				}
				
			}
			
			if(bwriter!=null){
				
				bwriter.flush();
				bwriter.close();
				
			}
			
			

			// status = tm.getuse
			System.out.println(status.getNextCursor());
			System.out.println(status.getPreviousCursor());
			System.out.println(status.getTotalNumber());
			System.out.println(status.getHasvisible());
			System.out.println(count);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
