export function arrayElements()
{
    let array=[5,6,7,8];
    let[,,a,]=array;
    console.log(a);
}

export function organizationObject()
{
    let organization={name:"tatechmo",
                      address:{street:"indu bussain Sarkar Road Jharkhand-814112",pincode:814112}
                    };
    let {address:{pincode}}=organization;
    console.log(pincode);
    
}
