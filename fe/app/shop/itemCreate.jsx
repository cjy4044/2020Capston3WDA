import React from 'react';
import ReactDOM from 'react-dom';
import './css/ItemCreate.css';

class ItemCreate extends React.Component {
    
    
    render() {
        
        return (
            <form method="post" encType="multipart/form-data" action="/shop/store">
                <div className="createItemBody">
                    <div className="div_center">상품 등록</div>
                    <input type="hidden" name="_csrf" value={document.cookie.split("=")[1]}/>
                    <div className="item">
                        <div className="leftBox">
                            <div>상품명</div>
                            <input type="text" name="title" placeholder="상품명" required/>
                            <div>간단설명</div>
                            <textarea name="info1" placeholder="간단한 설명을 입력하세요" required/>
                            <div>상세설명</div>
                            <textarea name="info2" placeholder="자세한 설명을 입력하세요" required/>
                        </div>
                        <div className="rightBox">
                            <label>대표 이미지</label>    
                            <input type="file" name="file1" required/>
                            <label>부가 이미지</label>    
                            <input type="file" name="file2" required/>

                            <label>상세 이미지</label>    
                            <input type="file" name="file3"/>
                        </div>    
                        <div>
                            <button>상품 등록</button>
                            <button>취소</button>
                        </div>
                    </div>
                </div>
            </form>
            
        )
    }
}

ReactDOM.render(<ItemCreate/>,document.getElementById('shopItemCreate'));