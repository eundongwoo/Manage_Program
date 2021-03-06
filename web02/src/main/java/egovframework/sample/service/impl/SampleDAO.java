package egovframework.sample.service.impl;

import java.util.List;

import egovframework.sample.service.SampleVO;

public interface SampleDAO {

	String insertSample(SampleVO vo) throws Exception;

	void updateSample(SampleVO vo) throws Exception;

	void deleteSample(SampleVO vo) throws Exception;

	SampleVO selectSample(SampleVO vo) throws Exception;

	List<?> selectSampleList(SampleVO vo) throws Exception;

}