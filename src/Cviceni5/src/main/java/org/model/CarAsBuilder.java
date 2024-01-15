package org.model;

public class CarAsBuilder {

        private String color;
        private double price;
        private String brand;
        private String engineType;

        private CarAsBuilder(Builder builder) {
            this.color = builder.color;
            this.price = builder.price;
            this.brand = builder.brand;
            this.engineType = builder.engineType;
        }

        // Static inner Builder class
        public static class Builder {
            private String color;
            private double price;
            private String brand;
            private String engineType;

            public Builder() {}

            public Builder setColor(String color) {
                this.color = color;
                return this;
            }

            public Builder setPrice(double price) {
                this.price = price;
                return this;
            }

            public Builder setBrand(String brand) {
                this.brand = brand;
                return this;
            }

            public Builder setEngineType(String engineType) {
                this.engineType = engineType;
                return this;
            }

            public CarAsBuilder build() {
                return new CarAsBuilder(this);
            }
        }

        @Override
        public String toString() {
            return "Car [color=" + color + ", price=" + price + ", brand=" + brand + ", engineType=" + engineType + "]";
        }
}
