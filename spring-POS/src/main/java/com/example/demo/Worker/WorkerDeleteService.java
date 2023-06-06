package com.example.demo.Worker;

import java.time.LocalDateTime;

public class WorkerDeleteService {
	private WorkerDao workerDao;
	
	public WorkerDeleteService(WorkerDao workerDao) {
		this.workerDao=workerDao;
	}
	
	public void delete(Worker req) throws Exception{
		Worker worker = workerDao.selectByID(req.getID());
		
		System.out.println(worker.getID());
		
		if(worker ==null) {
			throw new Exception("NullWorkerException");
		}
		
		
		workerDao.delete(worker.getID());
	}
}
