import React from 'react';
import Item from './Item';
export default class NewItem extends React.Component {
   
    render() {
        console.log(this.props.data);
        return (
            <div className="features_items">
                <h2 className="title text-center">신상품</h2>
                <Item data={this.props.data}></Item>
            </div>
        )
    }
}