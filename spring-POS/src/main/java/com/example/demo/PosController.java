package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Worker.Worker;
import com.example.demo.Worker.WorkerDao;
import com.example.demo.Worker.WorkerDeleteService;
import com.example.demo.Worker.WorkerModifyService;
import com.example.demo.Worker.WorkerRegisterRequest;
import com.example.demo.Worker.WorkerRegisterService;
import com.example.demo.inventory.Inventory;
import com.example.demo.inventory.InventoryDao;
import com.example.demo.inventory.InventoryDeleteService;
import com.example.demo.inventory.InventoryModifyService;
import com.example.demo.inventory.InventoryRegisterRequest;
import com.example.demo.inventory.InventoryRegisterService;
import com.example.demo.sell.Sell;
import com.example.demo.sell.SellDao;
import com.example.demo.sell.SellSearchService;
import com.example.demo.sell.SellStatisticsRegister;
import com.example.demo.sell.Statistics;

@Controller
public class PosController {
	@Autowired
	private WorkerDao workerDao;
	@Autowired
	private WorkerRegisterService workerRegisterService;
	@Autowired
	private WorkerModifyService workerModifyService;
	@Autowired
	private WorkerDeleteService workerDeleteService;
	
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private InventoryRegisterService inventoryRegisterService;
	@Autowired
	private InventoryModifyService inventoryModifyService;
	@Autowired
	private InventoryDeleteService inventoryDeleteService;
	
	@Autowired
	private SellDao sellDao;
	@Autowired
	private SellSearchService sellSearchService;
	@Autowired
	private SellStatisticsRegister sellStatisticsRegister;
	
	
	@RequestMapping({"/","/main"})
	public String main() {return "main";}
	
	//직원 관리 핸들러
	//직원 관리 창
	@RequestMapping(value="/worker/worker_option",method=RequestMethod.POST)
	public String handleWorker(Model model) {
		List<Worker> workerList = workerDao.selectAll();
		model.addAttribute("workers",workerList);
		return "worker/worker_option";
	}
	//직원 등록 누를시
	@RequestMapping(value="/worker/register_worker",method=RequestMethod.POST)
	public String handleRegisterWorker(Model model) {
		model.addAttribute("registerRequeset", new WorkerRegisterRequest());
		
		return "worker/register_worker";
	}
	//직원 등록 기입 사항
	@RequestMapping(value="/worker/register_success",method=RequestMethod.POST)
	public String handleRegisterSuccess(WorkerRegisterRequest WregReq,Model model) {
		try {
			System.out.println("handle: "+ WregReq.getID());
			workerRegisterService.regist(WregReq);
			model.addAttribute("worker", WregReq);
			
			return "/worker/register_success";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "/worker/register_worker";
		}
		
	}
	//정보 수정 
	@RequestMapping(value="/worker/modify_worker",method=RequestMethod.POST)
	public String handleModify(Worker worker, Model model) {
		model.addAttribute("worker",worker);
		return "/worker/modify_worker";
	}
	//정보 수정 적용
	@RequestMapping(value="/worker/modify_success",method=RequestMethod.POST)
	public String handleModifySuccess(Worker WregReq, Model model) {
		try {
			System.out.println(WregReq.getID());
			workerModifyService.modify(WregReq);
			model.addAttribute("worker", WregReq);
			
			return "/worker/modify_success";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "/worker/modify_worker";
		}
	}
	//직원 정보 삭제 여부 확인
	@RequestMapping(value="/worker/delete_agreement",method=RequestMethod.POST)
	public String handleDelete_agreement(Worker worker, Model model) {
		model.addAttribute("worker",worker);
		
		return "/worker/delete_agreement";
	}
	//직원 정보 삭제
	@RequestMapping(value="/worker/delete_success",method=RequestMethod.POST)
	public String handleDelete(Worker worker, Model model) {
		try {
			workerDeleteService.delete(worker);
			model.addAttribute("worker",worker);
			
			return "/worker/delete_success";
		}catch(Exception e) {
			return "/worker/delete_success";
		}
	}
	//
	//재고 관리
	@RequestMapping({"/inventory/inventory_management"})
	public String handleInventory(Model model) {
		List<Inventory> inventoryList = inventoryDao.selectAll();
		model.addAttribute("items",inventoryList);
		return "/inventory/inventory_management";
	}
	//신규 물품 등록 
	@RequestMapping(value="/inventory/register_item",method=RequestMethod.POST)
	public String handleRegisterItem(Model model) {
		model.addAttribute("registerRequest",new InventoryRegisterRequest());
		
		return "/inventory/register_item";
	}
	//신규 물품 등록 적용 
	@RequestMapping(value="/inventory/register_success",method=RequestMethod.POST)
	public String handleRegisterSuccess(InventoryRegisterRequest IregReq, Model model) {
		try {
			System.out.println("handle: "+ IregReq.getID());
			inventoryRegisterService.regist(IregReq);
			model.addAttribute("inventory", IregReq);
			
			return "/inventory/register_success";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "/inventory/register_item";
		}
	}
	//정보 수정 
	@RequestMapping(value="/inventory/modify_item",method=RequestMethod.POST)
	public String handleModifyItem(Inventory inventory, Model model) {
		model.addAttribute("inventory",inventory);
		return "/inventory/modify_item";
	}
	//정보 수정 적용
	@RequestMapping(value="/inventory/modify_success",method=RequestMethod.POST)
	public String handleModifyItemSuccess(Inventory IregReq,Model model) {
		try {
			System.out.println(IregReq.getID());
			inventoryModifyService.modify(IregReq);
			model.addAttribute("inventory", IregReq);
			
			return "/inventory/modify_success";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "/inventory/modify_item";
		}
	}
	//정보 삭제 여부 확인
	@RequestMapping(value="/inventory/delete_agreement",method=RequestMethod.POST)
	public String handleDeleteItemAgreement(Inventory inventory, Model model) {
		model.addAttribute("inventory",inventory);
		
		return "/inventory/delete_agreement";
	}
	//정보 삭제
	@RequestMapping(value="/inventory/delete_success",method=RequestMethod.POST)
	public String handleDeleteItem(Inventory inventory, Model model) {
		try {
			inventoryDeleteService.delete(inventory);
			model.addAttribute("inventory",inventory);
			
			return "/inventory/delete_success";
		}catch(Exception e) {
			return "/inventory/delete_success";
		}
	}
	
	
	
	//장바구니창
	@RequestMapping({"/sell/sell_management"})
	public String handleSell() {return "/sell/sell_management";}
	
	//장바구니 검색
	List<Sell> wishList=new ArrayList<>();
	@RequestMapping(value="/sell/sell_search",method=RequestMethod.POST)
	public String handleSellSearch(String search, Model model) {
		try {
			wishList.add(sellSearchService.search(search));
			model.addAttribute("items",wishList);
			return "/sell/sell_management";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "/sell/sell_management";
		}
	}

	//장바구니 초기화
	@RequestMapping(value="/sell/reset",method=RequestMethod.POST)
	public String handleSellResetList(Model model) {
		wishList.clear();
		model.addAttribute("items",wishList);
		return "/sell/sell_management";
	}
	
	//구매 요청 시 wishList안에 물품과 개수를 계산하여 총 금액 알려줌
	@RequestMapping(value="/sell/sell_agreement",method=RequestMethod.POST)
	public String handleSellAgreement(Model model) {
		int totalPrice=0;
		for(int i=0;i<wishList.size();i++) {
			System.out.println(wishList.get(i).getPrice());
			System.out.println(wishList.get(i).getCount());
			totalPrice+=(wishList.get(i).getPrice()*wishList.get(i).getCount());
		}
		model.addAttribute("totalPrice",totalPrice);
		return "/sell/sell_agreement";
	}
	

	//statistics 테이블에 추가(판매내역 테이블)
	@RequestMapping(value="/sell/sell_success",method=RequestMethod.POST)
	public String handleSellSuccess() {
		for(int i=0;i<wishList.size();i++) {
			sellStatisticsRegister.regist(wishList.get(i));
		}
		return "/sell/sell_success";
	}
	
	//수량 수정 +
	@RequestMapping(value="/sell/sell_countModifyPlus")
	public String handleSellCountModifyPlus(@RequestParam("clone_index") int index,Model model) {
		wishList.get(index-1).setCount(wishList.get(index-1).getCount()+1);
		model.addAttribute("items",wishList);
		return "/sell/sell_management";
	}
	
	//수량 수정 -
	@RequestMapping(value="/sell/sell_countModifyMinus")
	public String handleSellCountModifyMinus(@RequestParam("clone_index") int index,Model model) {
		if(wishList.get(index-1).getCount()==1) {
			wishList.remove(index-1);
			}else { 
			wishList.get(index-1).setCount(wishList.get(index-1).getCount()-1);
		}
		model.addAttribute("items",wishList);
		
		return "/sell/sell_management";
	}
	
	
	
	
	
	
	@RequestMapping({"/statistics/statistics"})
	public String handleStatistic() {return "/statistics/statistics";}
}
