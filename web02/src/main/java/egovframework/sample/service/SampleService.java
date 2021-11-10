package egovframework.sample.service;

import java.util.List;

public interface SampleService {

	void insertSample(SampleVO vo) throws Exception;

	void updateSample(SampleVO vo) throws Exception;

	void deleteSample(SampleVO vo) throws Exception;

	SampleVO selectSample(SampleVO vo) throws Exception;

	List<?> selectSampleList(SampleVO vo) throws Exception;

}