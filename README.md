# はじめに
このシステムはSlay the Spire2のカード情報を提供するための**非公式webAPIです**。このAPIから提供される**全てのテキストの著作権はMega Crit Gamesに帰属します**。
# システム概要
*Slay the Spire CardDB API*

ゲーム「**Slay the Spire2**」のカード情報を提供する非公式webAPI

# 提供する機能
出力はJSON形式で送られる
- カード名検索（前方一致）機能
- キャラクター名/コスト/カード種別/キーワード1・キーワード2を自由に指定した検索機能
- 規定済のキーワードを出力する機能

# 技術スタック
- 言語:Java17
- フレームワーク:SpringBoot
- ビルドツール:Maven
- DB:MySQL
- IDE:IntelliJ IDEA
- バージョン管理:git/github
# APIエンドポイント
## GET /name
カード名を前方一致で検索する
1枚のカードにつき強化前と強化後の2つのデータを返す
### パラメータ
?name=[カード名]
### レスポンス例(検索ワード:"悪魔化")
```HTTP
GET http://localhost:8080/name?name=悪魔化
```
``` JSON
[
    {
        "cardID":173,
        "cardName":"悪魔化",
        "cardType":"パワー",
        "rarity":"レア",
        "cost":"3",
        "effect":"ターン開始時、筋力2を得る。",
        "upgradedCardId":174
    },
    {
        "cardID":174,
        "cardName":"悪魔化＋",
        "cardType":"パワー",
        "rarity":"レア",
        "cost":"3",
        "effect":"ターン開始時、筋力3を得る。",
        "upgradedCardId":null
    }
    
]
```
## GET /search
カード名以外の情報からカードを検索する
検索に使用するパラメータは全て省略可能
また、キーワードは検索性を上げるために規定している（後述）
### パラメータ
- コスト(文字列） 
- レアリティ（文字列）
- カードタイプ（文字列）
- キャラクター名（文字列）
- キーワード1（文字列）
- キーワード2（文字列）
### レスポンス例(検索キーワード:キャラ名/リージェント,レアリティ/コモン,コスト/1,キーワード1/,エナジーゲイン,キーワード2/鍛造)
```HTTP
GET http://localhost:8080/search?charname=リージェント&rarity=コモン&cost=1&keyword1=エナジーゲイン&keyword2=鍛造
```
``` JSON
[
    {
        "cardID":425,
        "cardName":"剣の研磨",
        "cardType":"スキル",
        "rarity":"コモン",
        "cost":"1",
        "effect":"鍛造6。次のターン、エナジーを得る。",
        "upgradedCardId":426
    },
    {
        "cardID":426,
        "cardName":"剣の研磨＋",
        "cardType":"スキル",
        "rarity":"コモン",
        "cost":"1",
        "effect":"鍛造10。次のターン、エナジーを得る。",
        "upgradedCardId":null
    }

]
```
# DB構造
<img width="541" height="402" alt="stscard drawio" src="https://github.com/user-attachments/assets/9aed5ce1-cee0-4b35-9d72-c4d138e4af39" />

# TODO

現段階ではフロントエンド（DiscordBot)と同時並行的に開発を行っており、それと組み合わせることで最低限機能する段階であるため、単体でも動作する様今後追加するべき機能を列挙する。

- キーワード検索における、バックエンド側でのバリデーション処理
- エラーハンドリング処理の追加
