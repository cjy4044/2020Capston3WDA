import React from 'react'
import ReactDOM from 'react-dom';
import './css/blockChainCss.css';
class BlockChain extends React.Component {
    render() {
        return (
          <div>
              

              <div className="introduceRIROVote">
                <div><h3>블록체인이란?</h3></div>
                <a href="https://www.youtube.com/watch?v=BKLfMx5hscI&t=143s">블록체인이 무엇인지 확인하러 가기</a><br/>
                <div><h3>RIRO 블록체인 소개 및 투표 확인</h3></div><br/>
                <div>RIRO 는 카카오의 클레이튼 이라는 블록체인을 사용하였습니다.</div><br/>
                <a href="https://www.youtube.com/watch?v=vSbMehFESos">기대되는 클레이튼 (영상 바로가기)</a><br/>
                <a href="https://www.youtube.com/watch?v=3TzMub6OM6o&t=380s">상세설명 (영상 바로가기)</a><br/><br/>
                <div><h3>투표 확인</h3></div>
                <div>원하는 투표를 눌러서, 투표 정보를 봅시다.</div>
                <img src="/img/blockChain/selectVote.png"/>
                <div>진행중인 투표에 투표를 해봅시다. (후보 3번에 투표를 해 보았습니다.)</div>
                <img src="/img/blockChain/vote.png"></img>
                <div>그 다음, 오른쪽 아래(모바일: 최하단)에 있는 블록체인 주소 확인을 클릭합시다.</div>
                <img src="/img/blockChain/checkAdd.png"></img>
                <img src="/img/blockChain/checkAdd2.png"></img>
                <div><a href="https://baobab.scope.klaytn.com/">KlaytnScope</a> 에 접속하여, 블록체인 주소를 입력합시다.</div>
                <img src="/img/blockChain/scope.png"></img>
                <div>아래의 사진을 보면, 여러분이 투표한 정보가 있습니다.</div>
                <img src="/img/blockChain/showScopeVote.png"></img>
                <div>왼쪽의 주소를 클릭하거나, 이전에 확인한 내가 투표한 정보를 다시 검색해봅시다.</div>
                <img src="/img/blockChain/showInfo.png"></img>
                <div>여러분이 투표한 정보에 대한 값들이 아래에 나열되어있습니다.</div>
                <img src="/img/blockChain/userVoteInfo2.png"></img>
                <div>저희가 주목해야 할 것은, 이 문자들의 맨 마지막 숫자입니다. 이 숫자가 여러분이 투표한 후보의 번호가 맞나요?</div>
                <img src="/img/blockChain/code2.png"></img>

                <div>후보 번호가 10 이상일 경우, 숫자가 문자로 나타날 수 있습니다.</div>
              </div>
              
              
          </div>
        );
      }
}


ReactDOM.render(<BlockChain/>,document.getElementById('blockChain'));
