import React from 'react';
export default class OrderStateItem extends React.Component {
    constructor(props){
        super(props)

    }
    render() {
        console.log(this.props)
        if(this.props.data.length != 0){
            return this.props.data.map((item, index) => {
                return (
                    <div className="stateItem" key={index}>
                        <img src={"/uploads/"+item.image}/>
                        <div>상품명:{item.name} </div>
                        <div>전체 판매 개수: {item.sum}</div>
                    </div>
                 )
            })
        }else{
            return <div>상품이 없습니다.</div>
        }
        
        
    }
}