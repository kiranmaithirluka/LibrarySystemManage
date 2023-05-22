package com.librarysystem.repository;


	import org.springframework.data.jpa.repository.JpaRepository;

	import com.librarysystem.entity.Borrow;

	public interface BorrowRepository  extends JpaRepository<Borrow,Long> {


}
