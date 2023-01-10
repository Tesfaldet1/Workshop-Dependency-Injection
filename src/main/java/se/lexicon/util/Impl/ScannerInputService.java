package se.lexicon.util.Impl;

import org.springframework.stereotype.Component;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {
    @Override
    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
