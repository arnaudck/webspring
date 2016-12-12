package fr.treeptik.webspring.model.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_authorities")
public class Authority implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@Id
	@Column(length=50, nullable=false)
	private String authority;
	
	public Authority() {}

	public Authority(User user, String authority) {
		super();
		this.user = user;
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
