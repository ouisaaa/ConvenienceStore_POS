package com.example.demo.Worker;

import java.time.LocalDateTime;

public class WorkerRegisterService {
	private WorkerDao workerDao;
	
	public WorkerRegisterService(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}
	
	//신규 직원 등록
	public String regist(WorkerRegisterRequest req) throws Exception {
		Worker worker = workerDao.selectByID(req.getID());
		
		System.out.println(req.getID());
		System.out.println(worker);
		
		if(worker !=null) {
			throw new Exception("DuplicateMemberException");
		}
		Worker newWorker = new Worker(
				req.getID(),
				req.getPassword(),
				req.getName(),
				LocalDateTime.now(),
				req.getTitle()
		);
		workerDao.insert(newWorker);
		
		return newWorker.getID();
	}
}
