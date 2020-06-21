import React from 'react';
export default class CategoryD extends React.Component {
    constructor(props){
        super(props)

    }
    render() {
        // console.log(this.props)
        if(this.props.data){
            if(this.props.data.length != 0){
                return this.props.data.map((categoryD, index) => {
                    return (
                        // <li onClick={this.props.event.bind(this,categoryD.category,categoryD.category_d_id)}>{categoryD.category_d}</li>
                        <li key={index} onClick={this.props.event.bind(this,categoryD.category,categoryD.category_d_id,this.props.that)}>{categoryD.category_d}</li>
                     )
                })
            }else{
                return <div></div>
            }
        }else{
            return <div></div>
        }
    }
}