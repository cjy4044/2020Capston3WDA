import React from 'react';

export default class Item2 extends React.Component {
    constructor(props){
        super(props)

    }
    render() {
        console.log(this.props)
        if(this.props.data.length != 0){
            return this.props.data.map((prd, index) => {
                return (
                    <div key={index}>
                        <img src={"/uploads/"+prd.img}/>
                        <div>상품명: {prd.name}</div>
                        <div>옵션: {prd.optionName}</div>
                        <div>개수: {prd.count}</div>
                        <input type="hidden" name="productId" value={prd.id}/>
                        <input type="hidden" name="optionId" value={prd.optionId}/>
                        <input type="hidden" name="count" value={prd.count}/>
                    </div>
                 )
            })
        }else{
            return <div>상품이 없습니다.</div>
        }
        
        
    }
}