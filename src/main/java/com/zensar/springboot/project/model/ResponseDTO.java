package com.zensar.springboot.project.model;

import java.util.Set;

public class ResponseDTO {

	
	private int totalCount;
	private Set<Integer> Unique_UserId;
	
	public ResponseDTO(int totalCount, Set<Integer> unique_UserId) {
		super();
		this.totalCount = totalCount;
		this.Unique_UserId = unique_UserId;
	}
	
	
	public ResponseDTO() {
		
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public Set<Integer> getUnique_UserId() {
		return Unique_UserId;
	}


	public void setUnique_UserId(Set<Integer> unique_UserId) {
		Unique_UserId = unique_UserId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDTO other = (ResponseDTO) obj;
		if (Unique_UserId == null) {
			if (other.Unique_UserId != null)
				return false;
		} else if (!Unique_UserId.equals(other.Unique_UserId))
			return false;
		if (totalCount != other.totalCount)
			return false;
		return true;
	}


	
}
