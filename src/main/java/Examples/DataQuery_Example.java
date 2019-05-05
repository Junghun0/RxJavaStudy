package Examples;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class DataQuery_Example {

    public void usingDataQuery(){
        //1.데이터 입력
        //왼쪽에는 상품이름, 오른쪽에는 매출액
        List<Pair<String,Integer>> sales = new ArrayList<>();

        sales.add(Pair.of("TV",2500));
        sales.add(Pair.of("Camera",300));
        sales.add(Pair.of("TV",1600));
        sales.add(Pair.of("Phone",800));

        Maybe<Integer> tvSales = Observable.fromIterable(sales)
                //2. 매출 데이터 중 TV 매출을 필터링함
            .filter(sale -> "TV".equals(sale.getLeft()))
                .map(sale -> sale.getRight())
                //3. TV 매출의 합을 구함
                .reduce((sale1, sale2) -> sale1+sale2);
        tvSales.subscribe(tot -> System.out.println("TV Sales : $" + tot));
    }





    class ProductSales{
        private String mProduct;
        private int mSale;

        public String getmProduct() {
            return mProduct;
        }

        public void setmProduct(String mProduct) {
            this.mProduct = mProduct;
        }

        public int getmSale() {
            return mSale;
        }

        public void setmSale(int mSale) {
            this.mSale = mSale;
        }
    }
}
