package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Örnek bir koleksiyon oluşturalım
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);

        // Kullanıcıdan aranacak öğeyi alalım
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aranacak öğeyi giriniz: ");
        int target = scanner.nextInt();

        // Metodu çağırıp sonucu yazdıralım
        Integer result = findElement(collection, target);
        if (result != null) {
            System.out.println("Aradığınız öge var: " + result);
        } else {
            System.out.println("Sonuç bulunamadı (-1)");
        }
    }

    public static <T> T findElement(Collection<T> collection, T target) {
        // Stream API kullanarak koleksiyon üzerinde bir arama yapalım
        Optional<T> result = collection.stream()
                .filter(item -> item.equals(target))
                .findFirst();

        // Eğer bulunan bir sonuç varsa, bu sonucu döndürelim. Yoksa null döndürelim.
        return result.orElse(null);
    }
}
