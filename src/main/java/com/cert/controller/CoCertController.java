package com.cert.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyframeworks.base.entity.User;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.constants.ResultMsg;
import org.easyframeworks.core.web.manager.Client;
import org.easyframeworks.core.web.manager.ClientManager;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cert.entity.CoCert;
import com.cert.entity.CoInfo;
import com.cert.service.ICoCertService;
import com.cert.service.ICoInfoService;

/**
 * @class: CoinfoController
 * @description : 企业资质管理控制
 * @author Tor
 * @date 2014年5月14日 下午7:29:02
 */
@RestController
@RequestMapping("/cert/cocert")
public class CoCertController extends
		BaseControlSupport<CoCert, Integer, CoCert> {



	@Autowired
	private ICoInfoService coinfoService;
	@Autowired
	private ICoCertService cocertService;

	@Override
	public IBaseServiceSupport<CoCert, Integer> getBaseServiceSupport() {
		return cocertService;
	}

	@Override
	public String getBasePath() {
		// TODO Auto-generated method stub
		return "cert";
	}

	@Override
	public void goAddBefore(ModelAndView mav) {
		
	}
	
	@Override
	public void indexBefore(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		Client<User> client = (Client<User>) ClientManager.getInstance().getClient(request.getSession().getId());
		
	
		List<CoCert> list=  cocertService.findByProperty("coinfo.id", client.getSysUser().getRefId(), "id", "asc");
		mav.addObject("list_images",list);
	
		//List<DictData> dictDatas = dictDataService.findByProperty("dictType.code", "sexTypes", "id", "ASC");
		//mav.addObject("SEXTYPES", dictDatas);
	}
	
@ResponseBody
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public ResultMsg upload(HttpServletRequest request, HttpServletResponse response) throws Exception {  
	    
 System.out.println("%%%%%%%%%%%%%%%%%%%%");
       String name=request.getParameter("name");
	    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;//将HttpServletRequest对象转换为MultipartHttpServletRequest对象  
	       
	        /**得到文件保存目录的真实路径**/    
	        String logoRealPathDir = request.getSession().getServletContext().getRealPath("/upload/"+name+"/");    
	        /**根据真实路径创建目录**/    
	        File logoSaveFile = new File(logoRealPathDir);    
	        if(!logoSaveFile.exists()) {   
	            logoSaveFile.mkdirs();    
	        }  
	        /**页面控件的文件流**/    
	        MultipartFile multipartFile = multipartRequest.getFile("upload");     
	       
	        /**上传文件名称**/    
	        String logImageName = multipartFile.getOriginalFilename();//   
	     
	          
	        /**获取文件的后缀**/    
	        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);    
	        // 文件类型  
	         
	        // 获取文件大小，以kB为单位  
	        long size = multipartFile.getSize();  
	        Double fSize =Math.round(size/1024.0*100)/100.0;  
	        String fileSize = Double.toString(fSize)+"KB";  
	        //entiyVO.setFile_size(fileSize);  
	        /**拼成完整的文件保存路径加文件**/    
	        String fileName = logoRealPathDir + File.separator   + logImageName;    
	       // entiyVO.setUrl(fileName);  
	        File file = new File(fileName);     
	        // 设置response的Header  
//	        response.reset(); 
//	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"),"iso8859-1"));  
//	        response.addHeader("Content-Length", "" + file.length());  
	        ResultMsg resultMsg = new ResultMsg();
	        try {    
	            multipartFile.transferTo(file);  //将文件写入到指定的目录  
	      
	       
	        } catch (IllegalStateException e) {    
	        	resultMsg.pushError("上传失败");
	            e.printStackTrace();    
	        } catch (IOException e) { 
	        	resultMsg.pushError("上传失败");         
	            e.printStackTrace();    
	        }   
	        String path="/upload/"+name+"/"+logImageName;
	        resultMsg.pushOK(path);
    
	     
	      
	return resultMsg;
	  
	}  

 
	
}
