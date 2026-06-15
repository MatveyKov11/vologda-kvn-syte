<template>
    <div class="ui text container">
        <div class="ui fluid input">
            <input type="text" placeholder="Заголовок поста..." v-model="title"/>
        </div>
        <div class="ui segment" v-for="(block, i) in blocks" :key="i">
            <TextBlock :text="block.data" :colons-number="block.meta" v-if="block.type == 'text'"
                @add="(text) => addItem(i, text)" @delete="(j) => removeItem(i, j)"
                @up="(j) => upItem(i, j)" @down="(j) => downItem(i, j)"/>
            <ListBlock :text="block.data" :list-type="block.meta" v-else-if="block.type == 'list'"
                @add="(text) => addItem(i, text)" @delete="(j) => removeItem(i, j)"
                @up="(j) => upItem(i, j)" @down="(j) => downItem(i, j)"/>
            <VideoBlock :video-src="block.data[0]" v-else-if="block.type == 'video'"
                @edit="(src) => editVideo(i, src)" />
            <ImageBlock :image-src="block.data" :view-type="block.meta" v-else-if="block.type == 'image'"
                @add="(src) => addItem(i, src)" @delete="removeItem(i, block.data.length-1)"/>
            <TableBlock :table-id="block.data[0]" v-if="block.type == 'table'"/>
            <div class="ui right rail">
                <div class="ui buttons">
                    <div class="ui icon red button" @click="removeBlock(i)">
                        <i class="x icon"/>
                    </div>
                    <div class="ui icon primary button" @click="upBlock(i)">
                        <i class="arrow up icon"/>
                    </div>
                    <div class="ui icon primary button" @click="downBlock(i)">
                        <i class="arrow down icon"/>
                    </div>
                </div>
            </div>
            <div class="ui left rail" v-if="block.type == 'text'">
                <div class="ui segment">
                    <div class="ui form">
                        <div class="inline fields">
                            <label for="colons">Число колонок:</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="colons" value="1" v-model="block.meta">
                                    <label>1</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="colons" value="2" v-model="block.meta">
                                    <label>2</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="colons" value="3" v-model="block.meta">
                                    <label>3</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui left rail" v-else-if="block.type == 'list'">
                <div class="ui segment">
                    <div class="ui form">
                        <div class="inline fields">
                            <label for="list">Тип списка:</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="list" value="numb" v-model="block.meta">
                                    <label>1.</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="list" value="disc" v-model="block.meta">
                                    <label><i class="ui circle icon"/></label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="list" value="square" v-model="block.meta">
                                    <label><i class="ui square icon"/></label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui left rail" v-else-if="block.type == 'image'">
                <div class="ui segment">
                    <div class="ui form">
                        <div class="grouped fields">
                            <label for="img">Отображение:</label>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="img" value="gallery" v-model="block.meta">
                                    <label>Галерея</label>
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui radio checkbox">
                                    <input type="radio" name="img" value="carusel" v-model="block.meta">
                                    <label>Карусель</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <button class="ui button" @click="addBlock('text')">
        Текст
    </button>
    <button class="ui button" @click="addBlock('mark-list')">
        Маркированный список
    </button>
    <button class="ui button" @click="addBlock('numb-list')">
        Нумерованный список
    </button>
    <button class="ui button" @click="addBlock('photo')">
        Фото
    </button>
    <button class="ui button" @click="addBlock('video')">
        Видео
    </button>
    <button class="ui button" @click="addBlock('table')">
        Таблица
    </button>
    <div class="ui divider"/>
    <button class="ui button" @click="saveChanges">
        <i class="check icon"/> Сохранить изменения
    </button>
</template>

<script setup>
import { ref } from 'vue';
import TextBlock from './blocks/TextBlock.vue';
import ListBlock from './blocks/ListBlock.vue';
import VideoBlock from './blocks/VideoBlock.vue';
import ImageBlock from './blocks/ImageBlock.vue';
import TableBlock from './blocks/TableBlock.vue';

const blocks = ref([
    {
        type: 'text',
        data: [
            'Раз-раз-раз-раз-раз', 
            'Два-два-два-два-два-два-два', 
            'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два'+ 
            'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два'
        ],
        meta: 1
    },
    {
        type: 'list',
        data: [
            'Раз-раз-раз-раз-раз',
            'Два-два-два-два-два-два-два',
            'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два'
        ],
        meta: 'disc'
    },
    {
        type: 'list',
        data: [
            'Раз-раз-раз-раз-раз',
            'Два-два-два-два-два-два-два',
            'Два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два-два'
        ],
        meta: 'numb'
    },
    {
        type: 'video',
        data: ['https://vkvideo.ru/video_ext.php?oid=-127553155&id=456245257&hash=e92d9f33bf048f38&hd=3']
    },
    {
        type: 'image',
        data: ['https://i.pinimg.com/originals/7d/be/d9/7dbed90655c6d7de0f4d01eb01b9cbe1.jpg?nii=t', 
            'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fbabyimages.ru%2Fkartinki%2Fderevo-kartinka-03.jpg&f=1&nofb=1&ipt=53fa373c4b87731786d96ebfb42884d43ce1ca004478a2aeae755a9f2d8c5d26',
            'https://i.pinimg.com/originals/7d/be/d9/7dbed90655c6d7de0f4d01eb01b9cbe1.jpg?nii=t'
        ],
        meta: 'gallery'
    },
    {
        type: 'table',
        data: [0]
    }
])

const title = ref('Заголовок поста')

function addItem(i, text){
    blocks.value[i].data.push(text)
}

function removeItem(i, j){
    for (let k = j; k < blocks.value[i].data.length - 1; k++){
        blocks.value[i].data[k] = blocks.value[i].data[k+1]
    }
    blocks.value[i].data = blocks.value[i].data.slice(0, blocks.value[i].data.length - 1)
}

function upItem(i, j){
    if (j > 0){
        let temp = blocks.value[i].data[j-1].slice()
        blocks.value[i].data[j-1] = blocks.value[i].data[j].slice()
        blocks.value[i].data[j] = temp
    }
}

function downItem(i, j){
    if (j < blocks.value[i].data.length - 1){
        let temp = blocks.value[i].data[j].slice()
        blocks.value[i].data[j] = blocks.value[i].data[j+1].slice()
        blocks.value[i].data[j+1] = temp
    }
}

function editVideo(i, src){
    let begin = src.indexOf('src="')
    if(begin != -1){
        begin += 5
        blocks.value[i].data[0] = src.slice(begin, src.indexOf('"', begin))    
    }else{
        blocks.value[i].data[0] = src
    }
}

function addBlock(t){
    blocks.value.push({
        id: blocks.value.length,
        type: t,
        data: []
    })
}

function removeBlock(i){
    for (let j = i; j < blocks.value.length - 1; j++){
        blocks.value[j] = JSON.parse(JSON.stringify(blocks.value[j+1]))
        blocks.value[j].id = j
    }
    blocks.value = blocks.value.slice(0, blocks.value.length - 1)
}

function upBlock(j){
    if (j > 0){
        let temp = JSON.parse(JSON.stringify(blocks.value[j-1]))
        blocks.value[j-1] = JSON.parse(JSON.stringify(blocks.value[j]))
        blocks.value[j] = temp

        blocks.value[j-1].id = j-1
        blocks.value[j].id = j
    }
}

function downBlock(j){
    if (j < blocks.value.length - 1){
        let temp = JSON.parse(JSON.stringify(blocks.value[j+1]))
        blocks.value[j+1] = JSON.parse(JSON.stringify(blocks.value[j]))
        blocks.value[j] = temp

        blocks.value[j].id = j
        blocks.value[j+1].id = j+1
    }
}

function saveChanges(){
    console.log(JSON.stringify(blocks.value))
}
</script>

<style>
.video{
    width: 100%;
    height: 360px;
}
</style>