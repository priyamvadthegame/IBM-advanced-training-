export function newObjectOfArray()
{
    let names=['tom','jerry','evans'];
    let newobj={},ansobj=[];
    names.forEach((names)=>{
        newobj={name:names,length:names.length};
        ansobj.push(newobj);
    
    });

    console.log(ansobj);
}