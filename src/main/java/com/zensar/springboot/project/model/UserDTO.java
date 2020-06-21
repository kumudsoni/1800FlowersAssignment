package com.zensar.springboot.project.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserDTO  implements Serializable{

	Integer UserId;
	Integer Id;
	String Title;
	String Body;

	public UserDTO() {

	}

	public UserDTO(Integer userId, Integer id, String title, String body) {
		super();
		UserId = userId;
		Id = id;
		Title = title;
		Body = body;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	@Override
	public String toString() {
		return "UserDTO  [UserId=" + UserId + ", Id=" + Id + ", Title=" + Title + ", Body=" + Body + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (Body == null) {
			if (other.Body != null)
				return false;
		} else if (!Body.equals(other.Body))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		if (UserId == null) {
			if (other.UserId != null)
				return false;
		} else if (!UserId.equals(other.UserId))
			return false;
		return true;
	}

}
