package com.librarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.librarysystem.entity.Borrow;
import com.librarysystem.service.BorrowService;

@Controller

public class BorrowController {
	
	

		final BorrowService borrowService;

		public BorrowController(BorrowService borrowService) {
			this.borrowService = borrowService;

		}

		@RequestMapping("/borrows")
		public String findAllBorrows(Model model) {
       model.addAttribute("borrows", borrowService.findAllBorrows());
		return "list-borrows";
		}

		@RequestMapping("/borrow/{id}")
		public String findBorrowById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("borrow", borrowService.findBorrowById(id));
		return "list-borrows";
		}

		@GetMapping("/addborrow")
		public String showCreateForm(Borrow borrow) {
			return "add-borrow";
		}

		@RequestMapping("/add-borrow")
		public String createBorrow(Borrow borrow, BindingResult result, Model model) {
			if (result.hasErrors()) {
				return "add-borrow";
			}

			borrowService.createBorrow(borrow);
			model.addAttribute("borrow", borrowService.findAllBorrows());
			return "redirect:/borrows";
		}

		@GetMapping("/updateBorrow/{id}")
		public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("borrow", borrowService.findBorrowById(id));
			return "update-borrow";
		}

		@RequestMapping("/update-borrow/{id}")
		public String updateBorrow(@PathVariable("id") Long id, Borrow borrow, BindingResult result, Model model) {
			if (result.hasErrors()) {
				borrow.setId(id);
				return "update-borrow";
			}

			borrowService.updateBorrow(borrow);
			model.addAttribute("borrow", borrowService.findAllBorrows());
			return "redirect:/borrows";
		}

		@RequestMapping("/remove-borrow/{id}")
		public String deleteBorrow(@PathVariable("id") Long id, Model model) {
			borrowService.deleteBorrow(id);

			model.addAttribute("borrow", borrowService.findAllBorrows());
			return "redirect:/borrows";
		}

	}

