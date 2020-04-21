
export function orderObjectCreation()
{   let id=101;
    let price=20;
    let title='apple'
    let order={id:id,
                price:price,
                title:title,
                printOrder(){
                    console.log(this.price);
                },
                getTile()
                {
                    return this.title;
                }
            };
        console.log ( order.getTile());
        order.printOrder();
        let neworder =  Object.assign(order);
        neworder.printOrder();
}