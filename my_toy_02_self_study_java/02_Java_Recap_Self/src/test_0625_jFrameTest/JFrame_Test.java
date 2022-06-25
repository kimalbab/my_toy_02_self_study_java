package test_0625_jFrameTest;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrame_Test {

	public static void main(String[] args) {
		
		//새로운 jframe 생성
		JFrame jf = new JFrame();
		
		//jf의 좌표와 크기를 지정
		//jf.setBounds(600, 300, 300, 300);
		jf.setSize(380,180);
		jf.setLocation(400,200);
		
		//JF의 제목 설정
		jf.setTitle("로그인");
		
		//닫기 버튼을 눌렀을 때 프로그램 아예 나가도록 설정
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// 기본 레이아웃 설정 안하겠다.
		jf.setLayout(null);
		
		//---------------------------
		JLabel jl = new JLabel("아이디 : ");
		jl.setSize(80,30);
		jl.setLocation(30,30);
		jl.setHorizontalAlignment(JLabel.CENTER);
		jf.add(jl);
		
		//---------------------------
		JTextField jt = new JTextField();
		jt.setSize(110,30);
		jt.setLocation(110,35);
		
		jf.add(jt);
	
		
		//---------------------------
		jl=new JLabel("비밀번호 : ");
		jl.setSize(80,30);
		jl.setLocation(30,70);
		jf.add(jl);
		
		//---------------------------
		
		jt = new JTextField();
		jt.setSize(110,30);
		jt.setLocation(110,75);
		jf.add(jt);
		
		//---------------------------
		JButton jb = new JButton("로그인");
		jb.setSize(70,70);
		jb.setLocation(240, 35);
		jf.add(jb);
		
		
		//jf의 창이 보이도록 설정
		jf.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
