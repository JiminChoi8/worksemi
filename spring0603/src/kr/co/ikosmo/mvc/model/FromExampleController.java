package kr.co.ikosmo.mvc.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.management.AttributeValueExp;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ikosmo.mvc.vo.TBoardVO;

@Controller
public class FromExampleController {

	
		private static final int BUFFER_SIZE = 4086;

		@RequestMapping(value="/form1")
		public String viewform1() {
			return "form1";
		}
		//submit누르고 파라미터를 받을 메서드 저으이
		//request.getParameter("val1")을 스프링은 자동 관리 해준다.
		@RequestMapping(value="/ins1", method=RequestMethod.POST)
		public ModelAndView ins1(String val1) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("val1");//viewName
			StringBuffer sb  = new StringBuffer();
			sb.append("<p style='color:pink'>");
			sb.append(val1);
			sb.append("</p>");
			mav.addObject("val1",sb.toString());//전달 값
			return mav;
		}
		//ins2와 form2 추가
		@RequestMapping(value="/form2")
		public String viewform2() {
			return "form2";
		}
		//spring interceptor가 알아서 VO에 파라미터 값을 setter로 저장해준다.
		//@ModleAtribute("tvo")와 mav.addObject("tvo", vo)와 동일 

		@RequestMapping(value="/ins2", method=RequestMethod.POST)
		public ModelAndView ins2(@ModelAttribute("tvo") TBoardVO vo) {
			System.out.println("확인:"+vo.getWriter());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("val2");
			//mav.addObject("tvo", vo); 위에 적용 
			return mav;
		}
		
		@RequestMapping(value="/upform1")
		public String upform1() {
			return "upform1";
		}
		//업로드 처리
		//1.enctype="multiparat/form-data" => commons-fileupload.jar에 의해서
		//제공받은 클래스를 사용한다.
		//2. CommonsMultipartResolver를 설정을 해야 한다.
		//* => HttpServletRequest, HttpServletResponse등을 인자로 정의하면 스프링이 알아서 넣어준다. 
		@RequestMapping(value="/upsave1", method = RequestMethod.POST)
		public ModelAndView save1(MultipartFile mfile, HttpServletRequest req) {
			// 이미지가 저장될 절대 경로를 지정
			ModelAndView mav = new ModelAndView("success");//view의 이름을 생성자의 인자값으로 지정
			HttpSession session = req.getSession();
			String r_path=session.getServletContext().getRealPath("/");
			System.out.println("Path:"+r_path);
			String img_path="resources\\upload\\";
			System.out.println("imgPath:"+r_path);
			StringBuffer path = new StringBuffer();
			path.append(r_path).append(img_path);
			//이미지 이름을 연결
			String oriFn =mfile.getOriginalFilename(); //업로드 된 이미지 이름
			path.append(oriFn);
			System.out.println("FullPath:"+path);
			//파일업로드 실행
			File f = new File(path.toString());//실제 이미지가 저장될 경로
			try {
				mfile.transferTo(f);//스프링의 transferTo를 호출해서 이미지를 저장소에 복사  
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.addObject("imgName",oriFn);
			return mav;
		}

//		@RequestMapping(value="/upform2")
//		public String upform2() {
//			return "upform2";
//		}

//		@RequestMapping(value="/upsave2", method = RequestMethod.POST)
//		public ModelAndView save2(TBoardVO vo, HttpServletRequest req) {
//			// 이미지가 저장될 절대 경로를 지정
//			ModelAndView mav = new ModelAndView("success");//view의 이름을 생성자의 인자값으로 지정
//			HttpSession session = req.getSession();
//			String r_path=session.getServletContext().getRealPath("/");
//			System.out.println("Path:"+r_path);
//			String img_path="resources\\upload\\";
//			System.out.println("imgPath:"+r_path);
//			StringBuffer path = new StringBuffer();
//			path.append(r_path).append(img_path);
//			MultipartFile mfiles= vo.getMfile();
//			//이미지 이름을 연결
//			String oriFn = mfiles.getOriginalFilename(); //업로드 된 이미지 이름
//			path.append(oriFn);
//			System.out.println("FullPath:"+path);
//			//파일업로드 실행
//			File f = new File(path.toString());//실제 이미지가 저장될 경로
//			try {
//				mfiles.transferTo(f);//스프링의 transferTo를 호출해서 이미지를 저장소에 복사  
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			mav.addObject("imgName",oriFn);
//			return mav;
//		}
//		
//		//파일다운로드
//		@RequestMapping(value="/fileDown")
//		public void fildDonw(@RequestParam("fileName") String fileName,
//				HttpSession session, HttpServletRequest request,
//				HttpServletResponse response) throws IOException {
//			ServletContext context = request.getServletContext();
//			String r_path = session.getServletContext().getRealPath("/");
//			System.out.println("path:"+r_path);
//			String img_path ="resources\\upload\\";
//			System.out.println("imgPath:"+r_path);
//			StringBuffer path= new StringBuffer();
//			path.append(r_path).append(img_path);
//			System.out.println("path:"+path);
//			path.append(fileName);
//			//그 경로로 파일객체를 생성 : 추상경로로도 생성이 가능하다. 
//			File downloadFile = new File(path.toString());
//			//FileInputStream 스트림으로 읽어옴 : 이미지, 영상 등 바이너리 파일을 읽어오기 위한 자바 스트림 생성 
//			FileInputStream fi = new FileInputStream(downloadFile);
//			//요청객체로부터 연결될 브라우저의 마임타입(MimeType)을 얻어냄, 브라우저 통신간에 약속
//			String mimeType = context.getMimeType(path.toString());
//			//만약 마임타입값이 없으면 그냥 디폴트로 스트림으로 연결 
//			if(mimeType==null) {
//				mimeType="application/octet-stream";//브라우저로 다운로드를 진행하겠다는 마임타임을 설정 
//			}
//			//지정된 마임타입 세팅
//			//setContentType("text/html; charset=euc-kr") //html로 브라우저가 응답 준비 
//			response.setContentType(mimeType);
//			//다운로드될 파일의 길이 세팅
//			response.setContentLength((int) downloadFile.length());
//			//다운로드 Type을 설정함
//			String headerKey = "Content-Disposition";
//			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());//다운로드창에 이름명 띄우기 
//			//위로 다운로드 타입의 정보를 헤더로 설정해서 브라우저로 전송하면 브라우저가 해당 창에 맞게 다운로드 view  
//			response.setHeader(headerKey, headerValue);
//			//브라우저로부터 스트림을 연결
//			OutputStream outStream = response.getOutputStream();
//			//버퍼를 끼워서 빠르게 전달 목적
//			byte[] buffer = new byte[BUFFER_SIZE];
//			//이제 브라우저로 보내고, 자원 닫으면 끝
//			int bytesRead = -1;
//			while((bytesRead = fi.read(buffer))!=-1) {
//				outStream.write(buffer,0,bytesRead);
//			}
//			fi.close();
//			outStream.close();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
