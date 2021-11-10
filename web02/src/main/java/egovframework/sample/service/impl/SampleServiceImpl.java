package egovframework.sample.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;


@Service("sampleSevice")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService{
	@Resource(name="daoSpring") //autowired와 같다.
	private SampleDAO sampleDAO;
	@Resource(name="egovIdGnrService")                      
	private EgovIdGnrService egovIdGnrService;
	private String version;
	
	public SampleServiceImpl() throws Exception {
		System.out.println("==>SampleServiceImpl생성1");
	}
	
	public void insertSample(SampleVO vo) throws Exception{
		String id=egovIdGnrService.getNextStringId();
		System.out.println("id====>"+id);
		vo.setId(id);
		sampleDAO.insertSample(vo);
	}
	public void updateSample(SampleVO vo) throws Exception{
		
		sampleDAO.updateSample(vo);
	}
	public void deleteSample(SampleVO vo) throws Exception{
		
		sampleDAO.deleteSample(vo);
	}
	public SampleVO selectSample(SampleVO vo) throws Exception{
		
		return sampleDAO.selectSample(vo);
	}
	public List<?> selectSampleList(SampleVO vo) throws Exception{
		
		return sampleDAO.selectSampleList(vo);
	}

//	public void setSampleDAO(SampleDAO sampleDAO) {
//		System.out.println("--->setSampleDAO()호출");
//		this.sampleDAO = sampleDAO;
//	}
//
//	public void setVersion(String version) {
//		System.out.println("--->setVersion()호출");
//		this.version = version;
//	}
	
}
