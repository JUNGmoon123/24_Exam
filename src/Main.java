import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		
		
		Scanner sc = new Scanner(System.in);
		
		List<Saying> Sayings = new ArrayList<>();
		int LastNum = 0;
		System.out.println("== 명언 앱 실행 ==");
		while(true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();
			String[] cmdBit = cmd.split("\\?");
			switch(cmdBit[0]) {
			case "등록":
				int num = LastNum +1;
				String body = null;
				String auther = null;
				System.out.printf("명언 : ");
				body = sc.nextLine();
				System.out.printf("작가 : ");
				auther = sc.nextLine();
				System.out.printf("%d번 명언이 등록되었습니다.\n", num);
				int regDate = now.getYear();
				Sayings.add(new Saying(num,regDate,body,auther));
				LastNum++;
				break;
			case "목록":
				if(Sayings.size() == 0) {
					System.out.println("목록이 없어요.");
					continue;
				}
				System.out.println("번호	/	작가	/	명언");
				System.out.println("=".repeat(40));
				for(int i = Sayings.size()-1; i >= 0; i--) {
					Saying Saying = Sayings.get(i);
					System.out.printf("%d	/	%s	/	%s\n",Saying.getId(),Saying.getAuther(), Saying.getBody());
				}
				break;
			case "수정":
				
				Saying Saying = null;
				if(Sayings.size() == 0) {
					System.out.println("수정할게 없어요.");
					continue;
				}
				
				System.out.println("q");
				if(cmdBit.length == 1) {
					System.out.println("명령어를 확인 후 다시 입력하세요.");
					continue;
				}
				
				String[] cmdBits = cmd.split("\\=");
				int checkNum = Integer.parseInt(cmdBits[1]);
				for(int i = 0; i < Sayings.size(); i++) {
					if( checkNum == Sayings.get(i).getId()) {
						Saying = Sayings.get(i);
						System.out.println("명언을 수정할수 있습니다.");
					}
					else {
						System.out.printf("%d명언은 존재하지 않습니다.\n", Sayings.get(i).getId());
					}
				}
				System.out.print("명언(기존) :" );
				System.out.println(Saying.getBody());
				System.out.print("작가(기존) :");
				System.out.println(Saying.getAuther());
				
				System.out.print("명언 : ");
				Saying.setBody(sc.nextLine().trim());
				System.out.println();
				System.out.print("작가 : ");
				Saying.setAuther(sc.nextLine().trim());
				System.out.println();
				break;
			case "상세보기":
				Saying Saying1 = null;
				if(Sayings.size() == 0) {
					System.out.println("상세보기를 할수  없어요.");
					continue;
				}
				String[] cmdBits2 = cmd.split("\\=");
				int checkNum2 = Integer.parseInt(cmdBits2[1]);
				for(int i = Sayings.size()-1; i >= 0; i--) {
					if( checkNum2 == Sayings.get(i).getId()) {
						Saying1 = Sayings.get(i);
						System.out.println("상세보기를 볼 수 있습니다.");
					}
					else {
						continue;
					}
				}
				System.out.printf("번호 : %d\n",Saying1.getId());
				System.out.printf("날짜 : %d\n",Saying1.getRegDate());
				System.out.printf("작가 : %s\n",Saying1.getAuther());
				System.out.printf("내용 : %s\n",Saying1.getBody());
				
				break;
				
			case "삭제":
				Saying Saying2 = null;
				if(Sayings.size() == 0) {
					System.out.println("삭제할게 없어요.");
					continue;
				}
				String[] cmdBits3 = cmd.split("\\=");
				int checkNum3 = Integer.parseInt(cmdBits3[1]);
				for(int i = Sayings.size()-1; i >= 0; i--) {
					if( checkNum3 == Sayings.get(i).getId()) {
						Saying2 = Sayings.get(i);
						System.out.println("삭제를 할 수 있습니다.");
					}
					else {
						continue;
					}
				}
				System.out.printf("%d번 명언을 삭제했습니다.\n", Saying2.getId());
				Sayings.remove(Saying2);
			}
		}
	}
}

class Saying {
	private int id;
	private String body;
	private String auther;
	private int regDate;
	
	public Saying(int id,int regDate, String body, String auther) {
		this.id = id;
		this.body = body;
		this.auther = auther;
		this.regDate = regDate;
	}

	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}
}