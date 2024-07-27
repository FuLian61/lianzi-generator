import FileUploader from '@/components/FileUploader';
import { makeGeneratorUsingPost } from '@/services/backend/generatorController';
import { ProForm, ProFormItem } from '@ant-design/pro-form';
import { Collapse, Form, message } from 'antd';
import { saveAs } from 'file-saver';

interface Props {
  meta: API.GeneratorMakerRequest | API.GeneratorEditRequest;
}

/**
 * 生成器制作
 * @param props
 */
export default (props: Props) => {
  const { meta } = props;
  const [form] = Form.useForm();

  const doSubmit = async (values: API.GeneratorMakerRequest) => {
    // 校验
    // @ts-ignore
    if (!meta.name) {
      message.error('请填写名称');
      return;
    }
    const zipFilePath = values.zipFilePath;
    if (!zipFilePath || zipFilePath.length < 1) {
      message.error('请上传模板文件压缩包');
      return;
    }

    //文件列表转 url
    // @ts-ignore
    values.zipFilePath = zipFilePath[0].response;

    try {
      const blob = await makeGeneratorUsingPost(
        {
          // @ts-ignore
          meta,
          zipFilePath: values.zipFilePath,
        },
        {
          responseType: 'blob',
        },
      );
      saveAs(
        blob,
        // @ts-ignore
        meta.name + '.zip',
      );
    } catch (error: any) {
      message.error('下载失败，' + error.message);
    }
  };

  const fromView = (
    <ProForm
      form={form}
      submitter={{
        searchConfig: {
          submitText: '制作',
        },
        resetButtonProps: {
          hidden: true,
        },
      }}
      onFinish={doSubmit}
    >
      <ProFormItem label="模板文件" name="zipFilePath">
        <FileUploader
          biz="generator_make_template"
          description="请上传压缩包，打包时不要添加最外层目录！"
        />
      </ProFormItem>
    </ProForm>
  );
  return (
    <Collapse
      style={{ marginBottom: 24 }}
      items={[
        {
          key: 'maker',
          label: '生成器制作工具',
          children: fromView,
        },
      ]}
    ></Collapse>
  );
};
