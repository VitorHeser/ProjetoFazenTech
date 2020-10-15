/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.domain.mock;

import com.hitesh_sahu.retailapp.model.CenterRepository;
import com.hitesh_sahu.retailapp.model.entities.Product;
import com.hitesh_sahu.retailapp.model.entities.ProductCategoryModel;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class serve as fake server and provides dummy product and category with real Image Urls taken from flipkart
 */
public class FakeWebServer {

    private static FakeWebServer fakeServer;

    public static FakeWebServer getFakeWebServer() {

        if (null == fakeServer) {
            fakeServer = new FakeWebServer();
        }
        return fakeServer;
    }

    void initiateFakeServer() {

        addCategory();

    }

    public void addCategory() {

        ArrayList<ProductCategoryModel> listOfCategory = new ArrayList<ProductCategoryModel>();

//        listOfCategory
//                .add(new ProductCategoryModel(
//                        "Electronic",
//                        "Electric Items",
//                        "10%",
//                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeNSONF3fr9bZ6g0ztTAIPXPRCYN9vtKp1dXQB2UnBm8n5L34r"));

        listOfCategory
                .add(new ProductCategoryModel(
                        "Produtos",
                        "Produtos",
                        "0%",
                        "https://www.selecoes.com.br/wp-content/uploads/2019/11/shopping-bag-full-of-fresh-vegetables-and-fruits-picture-id1128687123-760x450.jpg"));

        CenterRepository.getCenterRepository().setListOfCategory(listOfCategory);
    }

    public void getAllElectronics() {

        ConcurrentHashMap<String, ArrayList<Product>> productMap = new ConcurrentHashMap<String, ArrayList<Product>>();

        ArrayList<Product> Verduras = new ArrayList<Product>();

        ArrayList<Product> Laticinios = new ArrayList<Product>();

        // Leites
        Laticinios.add(new Product(
                "Leite de Saquinho",
                "Leite retirado da fazenda direto para sua mesa",
                "-----",
                "9",
                "0",
                "5",
                "0",
                "https://i.imgur.com/is3SOLZ.png",
                "lei_1"));
        Laticinios.add(new Product(
                "Leite de Caixinha",
                "Leite retirado da fazenda direto para sua mesa",
                "-----",
                "12",
                "0",
                "8",
                "0",
                "https://i.imgur.com/EZgy0DA.png",
                "lei_2"));
        Laticinios.add(new Product(
                "Leite em Pó",
                "Leite retirado da fazenda direto para sua mesa",
                "-----",
                "12",
                "0",
                "8",
                "0",
                "https://i.imgur.com/BfRgJNX.png",
                "lei_3"));


        productMap.put("Leites", Laticinios);

        Verduras = new ArrayList<Product>();

        Verduras.add(new Product(
                "Leite de Saquinho",
                "Leite retirado da fazenda direto para sua mesa",
                "-----",
                "9",
                "0",
                "5",
                "0",
                "https://i.imgur.com/is3SOLZ.png",
                "lei_1"));


        productMap.put("Verduras", Verduras);
        CenterRepository.getCenterRepository().setMapOfProductsInCategory(productMap);

    }

    public void getAllProducts(int productCategory) {

        if (productCategory == 0) {

            getAllElectronics();
        }

    }

}
