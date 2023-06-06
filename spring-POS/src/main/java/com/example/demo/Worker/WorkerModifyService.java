package com.example.demo.Worker;

import java.time.LocalDateTime;

public class WorkerModifyService {
	private WorkerDao workerDao;
	
	public WorkerModifyService(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}
	
	public String modify(Worker req) throws Exception{
		Worker worker= workerDao.selectByID(req.getID());
		
		System.out.println(worker.getID());
		
		if(worker ==null) {
			throw new Exception("NullWorkerException");
		}
		Worker modifyWorker= new Worker(
			req.getID(),
			req.getPassword(),
			req.getName(),
			LocalDateTime.now(),
			req.getTitle()
		);
		workerDao.update(modifyWorker);
		
		return modifyWorker.getID();
	} 
	
}
