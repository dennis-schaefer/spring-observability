import {ProductService} from "Frontend/generated/endpoints";
import {useEffect, useState} from "react";
import Product from "Frontend/generated/de/schaeferd/sample/client/Product";
import {Button} from "@vaadin/react-components";


export default function HomeView()
{
    const [products, setProducts] = useState<Product[]>([]);

    const fetchProducts = () => {
        ProductService.findAll()
            .then(setProducts);
    };

    useEffect(() => {
        fetchProducts();
    }, []);

    return (
        <div className={"flex flex-col p-l gap-s"}>
            <div className={"flex"}>
                <h1 className={"w-full"}>Products</h1>
                <Button className={"w-auto"} onClick={fetchProducts}>Refresh</Button>
            </div>

            <div className={"flex gap-m"}>
                {products.map((product) => (
                    <div className={"shadow-s rounded-l p-m flex flex-col gap-s"} style={{"width": "250px"}} key={product.id}>
                        <h3>{product.name}</h3>
                        <span>{product.description}</span>
                        <span {...{ theme: 'badge success' }}>${product.price}</span>
                    </div>
                ))}
            </div>
        </div>
    );
}

