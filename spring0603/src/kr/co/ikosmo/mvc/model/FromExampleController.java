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
		//submit������ �Ķ���͸� ���� �޼��� ������
		//request.getParameter("val1")�� �������� �ڵ� ���� ���ش�.
		@RequestMapping(value="/ins1", method=RequestMethod.POST)
		public ModelAndView ins1(String val1) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("val1");//viewName
			StringBuffer sb  = new StringBuffer();
			sb.append("<p style='color:pink'>");
			sb.append(val1);
			sb.append("</p>");
			mav.addObject("val1",sb.toString());//���� ��
			return mav;
		}
		//ins2�� form2 �߰�
		@RequestMapping(value="/form2")
		public String viewform2() {
			return "form2";
		}
		//spring interceptor�� �˾Ƽ� VO�� �Ķ���� ���� setter�� �������ش�.
		//@ModleAtribute("tvo")�� mav.addObject("tvo", vo)�� ���� 

		@RequestMapping(value="/ins2", method=RequestMethod.POST)
		public ModelAndView ins2(@ModelAttribute("tvo") TBoardVO vo) {
			System.out.println("Ȯ��:"+vo.getWriter());
			ModelAndView mav = new ModelAndView();
			mav.setViewName("val2");
			//mav.addObject("tvo", vo); ���� ���� 
			return mav;
		}
		
		@RequestMapping(value="/upform1")
		public String upform1() {
			return "upform1";
		}
		//���ε� ó��
		//1.enctype="multiparat/form-data" => commons-fileupload.jar�� ���ؼ�
		//�������� Ŭ������ ����Ѵ�.
		//2. CommonsMultipartResolver�� ������ �ؾ� �Ѵ�.
		//* => HttpServletRequest, HttpServletResponse���� ���ڷ� �����ϸ� �������� �˾Ƽ� �־��ش�. 
		@RequestMapping(value="/upsave1", method = RequestMethod.POST)
		public ModelAndView save1(MultipartFile mfile, HttpServletRequest req) {
			// �̹����� ����� ���� ��θ� ����
			ModelAndView mav = new ModelAndView("success");//view�� �̸��� �������� ���ڰ����� ����
			HttpSession session = req.getSession();
			String r_path=session.getServletContext().getRealPath("/");
			System.out.println("Path:"+r_path);
			String img_path="resources\\upload\\";
			System.out.println("imgPath:"+r_path);
			StringBuffer path = new StringBuffer();
			path.append(r_path).append(img_path);
			//�̹��� �̸��� ����
			String oriFn =mfile.getOriginalFilename(); //���ε� �� �̹��� �̸�
			path.append(oriFn);
			System.out.println("FullPath:"+path);
			//���Ͼ��ε� ����
			File f = new File(path.toString());//���� �̹����� ����� ���
			try {
				mfile.transferTo(f);//�������� transferTo�� ȣ���ؼ� �̹����� ����ҿ� ����  
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
//			// �̹����� ����� ���� ��θ� ����
//			ModelAndView mav = new ModelAndView("success");//view�� �̸��� �������� ���ڰ����� ����
//			HttpSession session = req.getSession();
//			String r_path=session.getServletContext().getRealPath("/");
//			System.out.println("Path:"+r_path);
//			String img_path="resources\\upload\\";
//			System.out.println("imgPath:"+r_path);
//			StringBuffer path = new StringBuffer();
//			path.append(r_path).append(img_path);
//			MultipartFile mfiles= vo.getMfile();
//			//�̹��� �̸��� ����
//			String oriFn = mfiles.getOriginalFilename(); //���ε� �� �̹��� �̸�
//			path.append(oriFn);
//			System.out.println("FullPath:"+path);
//			//���Ͼ��ε� ����
//			File f = new File(path.toString());//���� �̹����� ����� ���
//			try {
//				mfiles.transferTo(f);//�������� transferTo�� ȣ���ؼ� �̹����� ����ҿ� ����  
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			mav.addObject("imgName",oriFn);
//			return mav;
//		}
//		
//		//���ϴٿ�ε�
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
//			//�� ��η� ���ϰ�ü�� ���� : �߻��ηε� ������ �����ϴ�. 
//			File downloadFile = new File(path.toString());
//			//FileInputStream ��Ʈ������ �о�� : �̹���, ���� �� ���̳ʸ� ������ �о���� ���� �ڹ� ��Ʈ�� ���� 
//			FileInputStream fi = new FileInputStream(downloadFile);
//			//��û��ü�κ��� ����� �������� ����Ÿ��(MimeType)�� ��, ������ ��Ű��� ���
//			String mimeType = context.getMimeType(path.toString());
//			//���� ����Ÿ�԰��� ������ �׳� ����Ʈ�� ��Ʈ������ ���� 
//			if(mimeType==null) {
//				mimeType="application/octet-stream";//�������� �ٿ�ε带 �����ϰڴٴ� ����Ÿ���� ���� 
//			}
//			//������ ����Ÿ�� ����
//			//setContentType("text/html; charset=euc-kr") //html�� �������� ���� �غ� 
//			response.setContentType(mimeType);
//			//�ٿ�ε�� ������ ���� ����
//			response.setContentLength((int) downloadFile.length());
//			//�ٿ�ε� Type�� ������
//			String headerKey = "Content-Disposition";
//			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());//�ٿ�ε�â�� �̸��� ���� 
//			//���� �ٿ�ε� Ÿ���� ������ ����� �����ؼ� �������� �����ϸ� �������� �ش� â�� �°� �ٿ�ε� view  
//			response.setHeader(headerKey, headerValue);
//			//�������κ��� ��Ʈ���� ����
//			OutputStream outStream = response.getOutputStream();
//			//���۸� ������ ������ ���� ����
//			byte[] buffer = new byte[BUFFER_SIZE];
//			//���� �������� ������, �ڿ� ������ ��
//			int bytesRead = -1;
//			while((bytesRead = fi.read(buffer))!=-1) {
//				outStream.write(buffer,0,bytesRead);
//			}
//			fi.close();
//			outStream.close();
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
