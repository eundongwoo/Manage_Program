package egovframework.sample.service.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoSpring")
public class SampleDAOSpring extends EgovAbstractDAO implements SampleDAO{
	
	
	public SampleDAOSpring() {
		System.out.println("====>SampleDAOSpring");
	}
	public String insertSample(SampleVO vo) throws Exception {
		return (String) insert("sampleDAO.insertSample", vo);
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSample(SampleVO vo) throws Exception {
		update("sampleDAO.updateSample", vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSample(SampleVO vo) throws Exception {
		delete("sampleDAO.deleteSample", vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	public SampleVO selectSample(SampleVO vo) throws Exception {
		return (SampleVO) select("sampleDAO.selectSample", vo);
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectSampleList(SampleVO vo) throws Exception {
		return list("sampleDAO.selectSampleList", vo);
	}

}
