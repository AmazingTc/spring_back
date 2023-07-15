import Mock from 'mockjs'
const count=200
let List=[]
// get请求从config.url获取参数，post从config.body中获取参数
function param2Obj (url) {
    const search = url.split('?')[1]
    if (!search) {
        return {}
    }
    return JSON.parse(
        '{"' +
        decodeURIComponent(search)
            .replace(/"/g, '\\"')
            .replace(/&/g, '","')
            .replace(/=/g, '":"') +
        '"}'
    )
}
for (let i = 0; i < count; i++) {
    List.push(
        Mock.mock({
            id: Mock.Random.guid().slice(0,5),
            name: Mock.Random.name(),
            author:Mock.Random.cname(),
            price:Mock.Random.float( 1, 99 ),
            synopsis:Mock.Random.paragraph( 1,1 )
        })
    )
}
export default {
    getBookList:config => {
        const { name, page = 1, limit = 20 } = param2Obj(config.url)
        console.log('name:' + name, 'page:' + page, '分页大小limit:' + limit)
        const mockList = List.filter(book => {
            if (name && book.name.indexOf(name) === -1 && book.addr.indexOf(name) === -1) return false
            return true
        })
        const pageList = mockList.filter((item, index) => index < limit * page && index >= limit * (page - 1))
        return {
            code: 20000,
            count: mockList.length,
            list: pageList
        }
    },
}
