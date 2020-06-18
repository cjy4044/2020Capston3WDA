import React from 'react';
export default class BagItem extends React.Component {
    render() {
        console.log(this.props.data);
        return this.props.data? this.props.data.map((prd, index) => {
            return (
                <div>
                    
                </div>
            )
        })
        :
        (
            <div>장바구니가 비었습니다.</div>
        )

    }
}