package com.microservicestock.domain.category.model.categoryExeption;

public class categoryErrorMessages extends RuntimeException  {

        private static final long serialVersionUID = 2L;

        private String errorMessage;

        public categoryErrorMessages(String errorMessage) {
            this.errorMessage = errorMessage;
        }
        public categoryErrorMessages() {
        }
        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }


}
