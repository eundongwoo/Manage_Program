package egovframework.sample.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;


@Controller
public class SampleController {
	@Resource	
	SampleService sampleService;
	@RequestMapping(value="/insertSample.do")
	public String insertSample(SampleVO vo) throws Exception {
		System.out.println("샘플등록처리");
		sampleService.insertSample(vo);
		return "forward:selectSampleList.do";
	}
	@RequestMapping(value="/updateSample.do")
	public String updateSample(SampleVO vo) throws Exception {
		System.out.println("샘플 수정 처리");
		sampleService.updateSample(vo);
		return "forward:selectSampleList.do";
	}
	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(SampleVO vo) throws Exception {
		sampleService.deleteSample(vo);
		return "forward:selectSampleList.do";
	}
	@RequestMapping(value="/selectSample.do")
	public ModelAndView selectSample(SampleVO vo,
			ModelAndView mv) throws Exception {
		mv.addObject("sample",sampleService.selectSample(vo));
		mv.setViewName("selectSample");
		return mv;
	}
	
	@RequestMapping(value="/selectSampleList.do")
	public ModelAndView selectSampleList(SampleVO vo,
			ModelAndView mv) throws Exception {   //자동주입
		System.out.println("샘플 목록 검색 처리");
		mv.addObject("sampleList",sampleService.selectSampleList(vo));
		mv.setViewName("selectSampleList");
		return mv;
	}
}
