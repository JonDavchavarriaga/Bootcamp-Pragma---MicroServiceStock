package com.microservicestock.domain.Category.CategoryModel.CategoryExeption;

public class CategoryErrorMessages extends RuntimeException  {

        private static final long serialVersionUID = 2L;

        private String errorMessage;

        public CategoryErrorMessages(String errorMessage) {
            this.errorMessage = errorMessage;
        }
        public CategoryErrorMessages() {
        }
        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }


}
