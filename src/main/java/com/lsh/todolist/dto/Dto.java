package com.lsh.todolist.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

public class Dto {
	@Getter
	public static class Post {
		@NotNull(message = "값이 비어있으면 안됩니다")
		@Length(min = 1, max = 20)
		@Pattern(regexp = "^$|[^ ]|^[^ ].*[^ ]$", message = "공백으로 시작하거나 끝나면 안됩니다")
		private String title;

		@NotNull(message = "값이 비어있으면 안됩니다")
		@Min(1)
		private Integer todoOrder = 555;

		@NotNull(message = "값이 비어있으면 안됩니다")
		private Boolean completed = false;
	}

	@Getter
	public static class Patch {
		@Setter
		private long id;

		@Length(min = 1, max = 20)
		@Pattern(regexp = "^$|[^ ]|^[^ ].*[^ ]$", message = "공백으로 시작하거나 끝나면 안됩니다")
		private String title;

		@Min(1)
		private Integer todoOrder;

		private Boolean completed;
	}
}
