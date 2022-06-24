package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.genericRepo;
import com.example.demo.service.GenericService;

public abstract class BaseController<T> {

	
	private final GenericService<T> service;
	
	public BaseController(genericRepo<T> repos) {
		this.service=new GenericService<T>(repos){}; 

		}
	
	
	@PostMapping("/ReadRecord")
	public T insertion(@Valid @RequestBody T t)
	{
		
		return service.insert(t);
	}
	
	@GetMapping("/fetchRecord")
	public List<T> getAllRecord()
	{
		return service.getAll();
	}
	
	@DeleteMapping("/record/{id}")
	
	public void DeleteRecord(@PathVariable("id") int id)
	{
		service.delete(id);
	}
	
	@PutMapping("/updateRecord")
	public T updateRecord(@RequestBody T t)
	{
		return service.update(t);
	}
	@GetMapping("/record/{id}")
	public Optional<T> getThrougID(@PathVariable("id") int id)
	{
		return service.getById(id);
	}
	
}
