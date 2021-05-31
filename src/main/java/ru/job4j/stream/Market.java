package ru.job4j.stream;

public class Market {
    private String name;
    private int codeName;
    private String location;
    private String firstIpAddress;
    private String secondIpAddress;
    private String email;
    private boolean works;

    @Override
    public String toString() {
        return "Market{"
                + "name='" + name + '\''
                + ", codeName=" + codeName
                + ", location='" + location + '\''
                + ", firstIpAddress='" + firstIpAddress + '\''
                + ", secondIpAddress='" + secondIpAddress + '\''
                + ", email='" + email + '\''
                + ", works=" + works
                + '}';
    }

    static class Builder {
        private String name;
        private int codeName;
        private String location;
        private String firstIpAddress;
        private String secondIpAddress;
        private String email;
        private boolean works;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildCodeName(int codeName) {
            this.codeName = codeName;
            return this;
        }

        Builder buildLocation(String location) {
            this.location = location;
            return this;
        }

        Builder buildFirstIpAddress(String firstIpAddress) {
            this.firstIpAddress = firstIpAddress;
            return this;
        }

        Builder buildSecondIpAddress(String secondIpAddress) {
            this.secondIpAddress = secondIpAddress;
            return this;
        }

        Builder buildEmail(String email) {
            this.email = email;
            return this;
        }

        Builder buildWorks(boolean works) {
            this.works = works;
            return this;
        }

        Market build() {
            Market market = new Market();
            market.name = name;
            market.codeName = codeName;
            market.location = location;
            market.firstIpAddress = firstIpAddress;
            market.secondIpAddress = secondIpAddress;
            market.email = email;
            market.works = works;
            return market;
        }
    }

    public static void main(String[] args) {
        Market market = new Builder().buildName("name")
                .buildCodeName(778899)
                .buildLocation("City, street, ap")
                .buildFirstIpAddress("8.8.8.8")
                .buildSecondIpAddress("7.7.7.7")
                .buildEmail("name@mail.ru")
                .buildWorks(false)
                .build();
        System.out.println(market);
    }
}

