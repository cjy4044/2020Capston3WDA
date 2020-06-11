import React, { Component } from 'react';
import Card from '@bit/jakeprins.react-milkshake.card';

class ItemCard4 extends Component{
    constructor(props){
		super(props);
    }

    render(){
        return (
            <div >
                <Card 
                    image={'/uploads/'+this.props.img}
                    title={this.props.name}
                    text={this.props.info}
                    centered={true}
                />
            </div>
        )
        
    }
}

export default ItemCard4