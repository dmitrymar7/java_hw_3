import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        ex1();
        //ex2();
        //ex3();
        //ex4();
    }

    public static void ex3(){
        //Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц.
        // Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания не позднее 2010 г.

        List<Book> books = new ArrayList<>();
        books.add(new Book("name1", "Author1", 200, 2000, 450));
        books.add(new Book("name2", "Author2", 200, 2009, 331));
        books.add(new Book("name3", "ex2", 200, 2000, 450));
        books.add(new Book("name4", "Author3", 200, 2000, 450));

        List<String> result = new ArrayList<>();

        for (Book book : books){
            if (book.getYear() > 2010){
                continue;
            }
            if (!isSimple(book.getCountPages())){
                continue;
            }
            if (book.getName().toLowerCase().contains("a")){
                result.add(book.getName());
            }
        }

        for (String str : result){
            System.out.println(str);
        }

    }

    public static boolean isSimple(int num){
        for (int i = 2; i <= num / 2; i++) {
            if (num % 2 == 0){
                return false;
            }
        }
        return true;
    }

    public static void ex2(){
        //Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта.
        // Получить наименования товаров заданного сорта с наименьшей ценой.

        List<Product> list = new ArrayList<>();
        list.add(new ProductEx2("prod1", 200, 1, "Russia", 2));
        list.add(new ProductEx2("prod2", 300.4, 2, "Denmark", 3));
        list.add(new ProductEx2("prod3", 10, 3, "Estonia", 5));
        list.add(new ProductEx2("prod4", 22, 1, "Netherlands", 2));
        list.add(new ProductEx2("prod5", 22, 1, "Greece", 4));

        List<String> listResult = new ArrayList<>();
        Double minPrice = null;

        int findGrade = 1;

        for (int i = 0; i < list.size(); i++) {
            Product currentProduct = list.get(i);

            if (currentProduct.getGrade() != findGrade){
                continue;
            }

            if (minPrice == null){
                listResult.add(currentProduct.getName());
                minPrice = currentProduct.getPrice();
                continue;
            }

            if(currentProduct.getPrice() < minPrice){
                listResult.clear();
                listResult.add(currentProduct.getName());
                minPrice = currentProduct.getPrice();
            }else if (Math.abs(currentProduct.getPrice() - minPrice) < 0.001){
                listResult.add(currentProduct.getName());
            }
        }

        for (String str : listResult){
            System.out.println(str);
        }

    }

    public static void ex1(){

        //Дан массив записей: наименование товара, цена, сорт.
        // Найти наибольшую цену товаров 1го или 2го сорта среди товаров, название которых содержит «высший».

        List<Product> list = new ArrayList<>();
        list.add(new Product("Высший сорт муки", 200, 1));
        list.add(new Product("prod2", 300.4, 2));
        list.add(new Product("prod3", 500, 3));
        list.add(new Product("prod4", 400, 2));
        list.add(new Product("Мука высший сорт", 22, 1));

        double maxPrice = 0;

        for (Product product : list){
            if (product.getGrade() != 1 && product.getGrade() != 2){
                continue;
            }

            if (!product.getName().toLowerCase().contains("высший")){
                continue;
            }

            if (product.getPrice() > maxPrice){
                maxPrice = product.getPrice();
            }

        }

        System.out.println("Наибольшая цена товара: " + maxPrice);

    }

    public static void ex4(){

        //при входном массиве, вернуть массив массивов со всеми перестановками его элементов. (со звездочкой)
        //Пример входных данных:
        //[1,2,3]
        //Пример выходных данных:
        //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        char[] chars = {'1', '2', '3'};
        char[][] result = permutations(chars);

        for (char[] array: result){
            System.out.println(Arrays.toString(array));
        }
    }

    public static char[][] permutations(char[] chars){
        char[][] result = new char[factorial(chars.length)][];

        generatePermutations(chars, result, 0);
        return result;
    }

    public static void generatePermutations(char[] chars, char [][] result, int currentIndex)
    {
        if (currentIndex == chars.length - 1) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] == null){
                    result[i] = Arrays.copyOf(chars, chars.length);
                    break;
                }
            }
            return;
        }

        for (int i = currentIndex; i < chars.length; i++) {
            swap(chars, currentIndex, i);
            generatePermutations(chars, result,currentIndex + 1);
            swap(chars, currentIndex, i);
        }
    }

    private static void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static int factorial(int num){
        if (num < 1){
            return 1;
        }

        return num * factorial(num - 1);
    }
}