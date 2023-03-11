package P05_Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder resultBuilder = new StringBuilder();
        for (String url : this.urls) {
            if (url.matches("[^\\d]+")) {
                resultBuilder.append("Browsing: ")
                        .append(url)
                        .append("!");
            } else {
                resultBuilder.append("Invalid URL!");
            }

            resultBuilder.append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder resultBuilder = new StringBuilder();
        for (String number : this.numbers) {
            if (number.matches("\\d+")) {
                resultBuilder.append("Calling... ")
                        .append(number);
            } else {
                resultBuilder.append("Invalid number!");
            }

            resultBuilder.append(System.lineSeparator());
        }
        return resultBuilder.toString();
    }
}
